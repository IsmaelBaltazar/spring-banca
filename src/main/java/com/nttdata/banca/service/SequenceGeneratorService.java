package com.nttdata.banca.service;

import com.nttdata.banca.model.document.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class SequenceGeneratorService {
    @Autowired(required=true)
    private ReactiveMongoOperations mongoOperations;

    public Integer getSequenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seqNumber",1);

        Mono<Sequence> counter = mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), Sequence.class);

        return !Objects.isNull(counter) ? counter.share().block().getSeqNumber():1;
    }
}
