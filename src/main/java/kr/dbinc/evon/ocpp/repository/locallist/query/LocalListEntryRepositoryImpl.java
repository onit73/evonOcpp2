package kr.dbinc.evon.ocpp.repository.locallist.query;

import kr.dbinc.evon.domain.locallist.QLocalListEntry;
import kr.dbinc.evon.domain.member.QAuthorization;
import kr.dbinc.evon.domain.member.QParentTag;
import kr.dbinc.evon.domain.locallist.LocalListVersion;
import kr.dbinc.evon.ocpp.repository.locallist.dto.EntryDto;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocalListEntryRepositoryImpl implements LocalListQueryRepository{

    private final EntityManager em;

    private final JPAQueryFactory query;


    public LocalListEntryRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<EntryDto> getAuthEntryDto(LocalListVersion version, Long maxSize) {
        QLocalListEntry e = QLocalListEntry.localListEntry;
        QAuthorization a = QAuthorization.authorization;
        QParentTag p = QParentTag.parentTag1;

        return query
                .select(Projections.constructor(EntryDto.class,
                        a.idToken,
                        a.expiryDate,
                        p.parentTag,
                        a.status))
                .from(e)
                .join(e.authorization, a)
                .leftJoin(a.parentTag, p)
                .where(e.version.eq(version))
                .orderBy(e.indexOfVersion.asc())
                .limit(maxSize)
                .fetch();
    }
}
