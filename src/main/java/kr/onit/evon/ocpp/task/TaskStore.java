package kr.onit.evon.ocpp.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.operations.changeconfiguration.ChangeConfigurationRequest;
import kr.onit.evon.ocpp.operations.getconfiguration.GetConfigurationRequest;
import kr.onit.evon.ocpp.types.RequestType;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
@Getter
@RequiredArgsConstructor
public class TaskStore {

    private final HashMap<Class<? extends RequestType>, Task> taskMap = new HashMap<>();

    private final GetConfigurationTask getConfigurationTask;
    private final ChangeConfigurationTask changeConfigurationTask;

    @PostConstruct
    private void initStore(){
        taskMap.put(GetConfigurationRequest.class, getConfigurationTask);
        taskMap.put(ChangeConfigurationRequest.class, changeConfigurationTask);
    }

    public Task getTask(Class<? extends RequestType> type){
        return taskMap.get(type);
    }
}
