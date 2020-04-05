package sk.stuba.fei.thesis.predicates;

import com.querydsl.core.types.Predicate;
import sk.stuba.fei.thesis.domain.model.actors.QUser;

public final class UserPredicates {

    private UserPredicates() {
    }

    public static Predicate hasIsNumber(Long isNumber) {
        return QUser.user.isID.eq(isNumber);
    }

    public static Predicate hasIsName(String isName) {
        return QUser.user.isName.eq(isName);
    }

}

