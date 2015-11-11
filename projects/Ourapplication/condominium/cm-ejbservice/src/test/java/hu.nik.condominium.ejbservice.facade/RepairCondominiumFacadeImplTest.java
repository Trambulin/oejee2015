package hu.nik.condominium.ejbservice.facade;

import hu.nik.condominium.ejbservice.converter.RepairCondominiumConverter;
import hu.nik.condominium.ejbservice.domain.RepairCondominiumStub;
import hu.nik.condominium.ejbservice.exception.FacadeException;
import hu.nik.condominium.persistence.exception.PersistenceServiceException;
import hu.nik.condominium.persistence.result.RepairCondominiumResult;
import hu.nik.condominium.persistence.service.ReparService;
import org.hamcrest.Matchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RepairCondominiumFacadeImplTest {

    @InjectMocks
    private RepairCondominiumFacadeImpl repairCondominiumFacade ;

    @Mock
    private RepairCondominiumConverter repairCondominiumConverter;

    @Mock
    private ReparService reparService;

    @BeforeMethod
    private void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createListOfAverageCostOfRepairGroupByCondominium() throws PersistenceServiceException, FacadeException {
        List<RepairCondominiumResult> results=new ArrayList<>();
        results.add(new RepairCondominiumResult(1L, 150000D));
        results.add(new RepairCondominiumResult(2L, 200000D));
        results.add(new RepairCondominiumResult(1L, 300000D));

        Mockito.when(reparService.getAvgGbyCondominium()).thenReturn(results);

        List<RepairCondominiumStub> stubList=new ArrayList<>();
        stubList.add(new RepairCondominiumStub(1L, 150000D));
        stubList.add(new RepairCondominiumStub(1L, 150000D));
        stubList.add(new RepairCondominiumStub(1L, 150000D));
        Mockito.when(repairCondominiumConverter.to(results)).thenReturn(stubList);

        List<RepairCondominiumStub> res=repairCondominiumFacade.getAvgOfRepairsGroupByCondominium();

        Mockito.verify(repairCondominiumConverter).to(results);

        assertThat(res, is(Matchers.contains(stubList.toArray())));
    }
}
