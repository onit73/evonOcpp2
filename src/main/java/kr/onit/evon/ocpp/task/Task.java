package kr.onit.evon.ocpp.task;

import kr.onit.evon.ocpp.rpc.TaskContext;

public interface Task {

    void execute(TaskContext context);
}
