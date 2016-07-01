package com.epam.serhii_potapov.report;

import com.epam.serhii_potapov.contexts.MobServerContext;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarRequest;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Serhii_Potapov on 6/27/2016.
 */
public class RequestsTable {
    private static final Logger LOG = Logger.getRootLogger();

    private static Set<Map.Entry<String, Long>> getRequestInfo() {
        Har har = MobServerContext.getServer().getHar();
        Map<String, Long> hashMap = new HashMap<>();
        for (HarEntry entry : har.getLog().getEntries()) {
            HarRequest request = entry.getRequest();
            hashMap.put(request.getUrl(), entry.getTime());
        }
        Set<Map.Entry<String, Long>> set = new TreeSet<>((o1, o2) ->
                (o1.getValue() >= o2.getValue()) ? -1 : 1);
        set.addAll(hashMap.entrySet());
        return set;
    }

    public static void printRequestInfo() {
        for (Map.Entry<String, Long> out : getRequestInfo()) {
            LOG.info(out.getKey() + " : " + out.getValue() + " ms");
        }
    }
}
