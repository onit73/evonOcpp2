package kr.onit.evon.ocpp.rpc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import kr.onit.evon.ocpp.component.PreviousRequestStore;
import kr.onit.evon.ocpp.component.ResultStore;
import kr.onit.evon.ocpp.rpc.message.CallResult;
import kr.onit.evon.ocpp.task.Task;
import kr.onit.evon.ocpp.task.TaskStore;
import kr.onit.evon.ocpp.types.RequestType;
import kr.onit.evon.ocpp.types.ResponseType;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@RequiredArgsConstructor
public class ResultHandlerImpl implements ResultHandler{

    private final ResultStore resultStore;
    private final PreviousRequestStore previousRequestStore;
    private final ThreadLocal<String> chargePointIdStore;
    private final TaskStore taskStore;

    @Override
    public void handleResult(CallResult result) {
        RequestType request = previousRequestStore.getRequestAndRemove(result.getUniqueId());
        ResponseType response = result.getPayload();

        TaskContext context = new TaskContext(chargePointIdStore.get(), request, response);
        execute(context);
        log.info("handleResult::::::::::::::::"+result.getUniqueId()+result.getPayload());
        resultStore.addResult(result.getUniqueId(), result.getPayload());
    }

    private void execute(TaskContext context){
        Task task = taskStore.getTask(context.getRequest().getClass());
        if(task != null)
            task.execute(context);
    }
}
