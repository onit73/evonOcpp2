package kr.dbinc.evon.ocpp.task;

import kr.dbinc.evon.ocpp.rpc.TaskContext;

public interface Task {

    void execute(TaskContext context);
}
