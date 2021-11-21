package mapper;

import dao.SearchRecord;
import dao.SearchRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchRecordMapper {
    long countByExample(SearchRecordExample example);

    int deleteByExample(SearchRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SearchRecord record);

    int insertSelective(SearchRecord record);

    List<SearchRecord> selectByExample(SearchRecordExample example);

    SearchRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SearchRecord record, @Param("example") SearchRecordExample example);

    int updateByExample(@Param("record") SearchRecord record, @Param("example") SearchRecordExample example);

    int updateByPrimaryKeySelective(SearchRecord record);

    int updateByPrimaryKey(SearchRecord record);
}