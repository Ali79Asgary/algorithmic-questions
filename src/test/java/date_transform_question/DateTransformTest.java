package date_transform_question;

import date_transfom_question.DateTransform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DateTransformTest {
    @Test
    public void transformDateFormat_ExampleCase_returnList() {
        List<String> dateList = Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20130720");
        List<String> resultList = DateTransform.transformDateFormat(dateList);
        List<String> excepted = Arrays.asList("20100220", "20161219", "20121118");
        Assertions.assertEquals(resultList, excepted);
    }

    @Test
    public void transformDateFormat_ContainingSingleFormat_returnList() {
        List<String> dateList = Arrays.asList("2010/02/20", "2016/09/12", "2012/19/12", "2013/07/20");
        List<String> resultList = DateTransform.transformDateFormat(dateList);
        List<String> excepted = Arrays.asList("20100220", "20160912", "20121912", "20130720");
        Assertions.assertEquals(resultList, excepted);
    }

    @Test
    public void transformDateFormat_ContainingMultipleFormats_returnList() {
        List<String> dateList = Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20-07-2013");
        List<String> resultList = DateTransform.transformDateFormat(dateList);
        List<String> excepted = Arrays.asList("20100220", "20161219", "20121118", "20132007");
        Assertions.assertEquals(resultList, excepted);
    }

    @Test
    public void transformDateFormat_ContainingMultipleFormatsAndSomeFormatsShouldBeIgnored_returnList() {
        List<String> dateList = Arrays.asList("2018/10/20", "19/10/2015", "11-14-2018", "2013125");
        List<String> resultList = DateTransform.transformDateFormat(dateList);
        List<String> excepted = Arrays.asList("20181020", "20151019", "20181114");
        Assertions.assertEquals(resultList, excepted);
    }
}
