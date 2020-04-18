package sk.stuba.fei.thesis.predicates;

import com.querydsl.core.types.Predicate;
import sk.stuba.fei.thesis.domain.model.actors.QUser;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

public final class UserPredicates {

    private UserPredicates() {
    }

    public static Predicate hasIsNumber(Long isNumber) {
        return QUser.user.isID.eq(isNumber);
    }

    public static Predicate hasIsName(String isName) {
        return QUser.user.isName.eq(isName);
    }

    public static Predicate hasAnyIdentityAttribute(String queryIdentityAttribute) {
        QUser user = QUser.user;
        return user.isName
                .likeIgnoreCase(queryIdentityAttribute)
                .or(
                        user.firstName.likeIgnoreCase(queryIdentityAttribute))
                .or(
                        user.middleName.likeIgnoreCase(queryIdentityAttribute))
                .or(
                        user.lastName.likeIgnoreCase(queryIdentityAttribute))
                .or(
                        user.isID.goe(Long.parseLong(queryIdentityAttribute)));
    }

    public static Predicate hasUserType(UserType type) {
        return QUser.user.userType.eq(type);
    }

}

