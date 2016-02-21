package org.spring.action.spitter.data;

import java.util.List;

import org.spring.action.spitter.Spittle;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
