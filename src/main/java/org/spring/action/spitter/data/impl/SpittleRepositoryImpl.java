package org.spring.action.spitter.data.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.spring.action.spitter.Spittle;
import org.spring.action.spitter.data.SpittleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            spittles.add(new Spittle(Long.valueOf(i), "message_" + i, new Date(), Double.valueOf(100 * i),
                    Double.valueOf(1000 * i)));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return new Spittle(Long.valueOf(spittleId), "message_" + spittleId, new Date(), Double.valueOf(100 * spittleId),
                Double.valueOf(1000 * spittleId));
    }

}
