package kr.onit.evon.app.price.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVariablePrice is a Querydsl query type for VariablePrice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVariablePrice extends EntityPathBase<VariablePrice> {

    private static final long serialVersionUID = 20759350L;

    public static final QVariablePrice variablePrice = new QVariablePrice("variablePrice");

    public final StringPath endDate = createString("endDate");

    public final NumberPath<Float> highLoadWithLow = createNumber("highLoadWithLow", Float.class);

    public final NumberPath<Float> highLoadWithLow2 = createNumber("highLoadWithLow2", Float.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Float> lowLoadWithLow = createNumber("lowLoadWithLow", Float.class);

    public final NumberPath<Float> lowLoadWithLow2 = createNumber("lowLoadWithLow2", Float.class);

    public final NumberPath<Float> midLoadWithLow = createNumber("midLoadWithLow", Float.class);

    public final NumberPath<Float> midLoadWithLow2 = createNumber("midLoadWithLow2", Float.class);

    public final StringPath startDate = createString("startDate");

    public final NumberPath<Integer> t01 = createNumber("t01", Integer.class);

    public final NumberPath<Integer> t02 = createNumber("t02", Integer.class);

    public final NumberPath<Integer> t03 = createNumber("t03", Integer.class);

    public final NumberPath<Integer> t04 = createNumber("t04", Integer.class);

    public final NumberPath<Integer> t05 = createNumber("t05", Integer.class);

    public final NumberPath<Integer> t06 = createNumber("t06", Integer.class);

    public final NumberPath<Integer> t07 = createNumber("t07", Integer.class);

    public final NumberPath<Integer> t08 = createNumber("t08", Integer.class);

    public final NumberPath<Integer> t09 = createNumber("t09", Integer.class);

    public final NumberPath<Integer> t10 = createNumber("t10", Integer.class);

    public final NumberPath<Integer> t11 = createNumber("t11", Integer.class);

    public final NumberPath<Integer> t12 = createNumber("t12", Integer.class);

    public final NumberPath<Integer> t13 = createNumber("t13", Integer.class);

    public final NumberPath<Integer> t14 = createNumber("t14", Integer.class);

    public final NumberPath<Integer> t15 = createNumber("t15", Integer.class);

    public final NumberPath<Integer> t16 = createNumber("t16", Integer.class);

    public final NumberPath<Integer> t17 = createNumber("t17", Integer.class);

    public final NumberPath<Integer> t18 = createNumber("t18", Integer.class);

    public final NumberPath<Integer> t19 = createNumber("t19", Integer.class);

    public final NumberPath<Integer> t20 = createNumber("t20", Integer.class);

    public final NumberPath<Integer> t21 = createNumber("t21", Integer.class);

    public final NumberPath<Integer> t22 = createNumber("t22", Integer.class);

    public final NumberPath<Integer> t23 = createNumber("t23", Integer.class);

    public final NumberPath<Integer> t24 = createNumber("t24", Integer.class);

    public final StringPath title = createString("title");

    public QVariablePrice(String variable) {
        super(VariablePrice.class, forVariable(variable));
    }

    public QVariablePrice(Path<? extends VariablePrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVariablePrice(PathMetadata metadata) {
        super(VariablePrice.class, metadata);
    }

}

