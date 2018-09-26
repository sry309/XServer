package monkeylord.XServer.api;

import java.util.Map;

import monkeylord.XServer.XServer;
import monkeylord.XServer.XposedEntry;
import monkeylord.XServer.handler.ClassHandler;

public class ClassView implements XServer.Operation {
    @Override
    public String handle(String url, Map<String, String> parms, Map<String, String> headers, Map<String, String> files) {
        try {
            return XServer.render(
                    ClassHandler.getClassDetail(
                            ClassHandler.findClassbyName(parms.get("class"), XposedEntry.classLoader)),
                    "pages/classview.html");
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
}