package p06MilitaryElite.domain.LieutenantGeneral;

import java.util.Set;

import p06MilitaryElite.domain.Private.Private;

public interface ILieutenantGeneral {

    void addPrivate(Private pS);
    Set<Private> getPrivates();

}
