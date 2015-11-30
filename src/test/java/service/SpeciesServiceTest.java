package service;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class SpeciesServiceTest {

    private SpeciesService speciesService;

    @Before
    public void setUp() throws Exception {
        speciesService = new SpeciesService();
    }

    @Test
    public void testTakeAllSpecies() throws Exception {
        int total = speciesService.getTotal();

        assertThat(total, is( speciesService.getSpecies().size() ));
    }
}
