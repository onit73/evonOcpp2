package kr.dbinc.evon.util;

import java.util.Arrays;
import java.util.List;

public class ConditionHandler<T> {

    private final T target;

    public ConditionHandler(T target) {
        this.target = target;
    }

    @SafeVarargs
    public final boolean in(T... conditions){
        return Arrays
                .asList(conditions)
                .contains(target);
    }

    public final boolean in(List<T> conditions){
        return conditions.contains(target);
    }

    @SafeVarargs
    public final boolean notIn(T... conditions){
        return !in(conditions);
    }

    public final boolean notIn(List<T> conditions){
        return !in(conditions);
    }
}
