package kr.onit.evon.ocpp.component;




import com.google.common.base.Preconditions;

import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class TypeStoreImpl implements TypeStore {

    private static final String REQUEST_CLASS_SUFFIX = "Request";
    private static final String RESPONSE_CLASS_SUFFIX = "Response";

    private final Map<String, Class<? extends RequestType>> requestClassMap = new HashMap<>();
    private final Map<Class<? extends RequestType>, Class<? extends ResponseType>> responseClassMap = new HashMap<>();

    public TypeStoreImpl(@Qualifier("typeStorePackage") String packageForRequestClassMap,
                         @Qualifier("typeStorePackage") String packageForResponseClassMap) {
        log.debug("====== Initialize Begin TypeStoreImpl ======");
        populateRequestClassMap(packageForRequestClassMap);
        populateActionResponseMap(packageForResponseClassMap);
        log.debug("====== Initialize End TypeStoreImpl ======");
    }

    @PostConstruct
    public void postConstructor(){
        log.debug("====== Class Type Reflection Call ======");
        log.debug("requestClassMap={} responseClassMap={}", requestClassMap, responseClassMap);
    }

    @Override
    public Class<? extends RequestType> findRequestClass(String action) {
        return requestClassMap.get(action);
    }

    @Override
    public <T extends RequestType> Class<? extends ResponseType> findResponseClass(T requestPayload) {
        return responseClassMap.get(requestPayload.getClass());
    }


    private void populateRequestClassMap(String packageName) {
        Set<Class<? extends RequestType>> classes = findClassesWithInterface(packageName, RequestType.class);
        log.debug("call populateRequestClassMap classes={}", classes);
        for (Class<? extends RequestType> clazz : classes) {
            String action = getAction(clazz);
            Preconditions.checkNotNull(action);
            requestClassMap.put(action, clazz);
        }
    }

    private void populateActionResponseMap(String packageName) {
        Set<Class<? extends RequestType>> requestClasses = findClassesWithInterface(packageName, RequestType.class);
        Set<Class<? extends ResponseType>> responseClassesSet = findClassesWithInterface(packageName, ResponseType.class);
        Map<String, Class<? extends ResponseType>> responseClasses = new HashMap<>();

        for (Class<? extends ResponseType> clazz : responseClassesSet)
            responseClasses.put(clazz.getSimpleName(), clazz);

        for (Class<? extends RequestType> requestClass : requestClasses) {
            String action = getAction(requestClass);
            Preconditions.checkNotNull(action);

            String responseClassSimpleName = action + RESPONSE_CLASS_SUFFIX;
            Class<? extends ResponseType> responseClass = responseClasses.get(responseClassSimpleName);
            Preconditions.checkNotNull(responseClass);

            responseClassMap.put(requestClass, responseClass);
        }
    }

    public <INTERFACE> Set<Class<? extends INTERFACE>> findClassesWithInterface(
            String packageName,
            Class<INTERFACE> interfaceClass)
    {
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackage(packageName));

        log.debug("Call findClassesWithInterface, reflections={}, packageName={}", reflections.getConfiguration().getClassLoaders(), packageName);
        return new HashSet<>( reflections.getSubTypesOf(interfaceClass) );
    }

    private static String getAction(Class<? extends RequestType> clazz) {
        String s = clazz.getSimpleName();
        if (s.endsWith(REQUEST_CLASS_SUFFIX)) {
            s = s.substring(0, s.length() - REQUEST_CLASS_SUFFIX.length());
        }
        return s;
    }

}
