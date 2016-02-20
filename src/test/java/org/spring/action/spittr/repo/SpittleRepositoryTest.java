package org.spring.action.spittr.repo;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.spring.action.spitter.Spittle;
import org.spring.action.spitter.data.SpittleRepository;
import org.spring.action.spittr.web.BaseControllerTest;

public class SpittleRepositoryTest extends BaseControllerTest{

    @Test
    public void show() {
        List<Spittle> spittles = createSpittleList(20);
        SpittleRepository spittleRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(spittleRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(spittles);

        super.get("");
    }

    private List<Spittle> createSpittleList(int i) {
        return null;
    }
}
