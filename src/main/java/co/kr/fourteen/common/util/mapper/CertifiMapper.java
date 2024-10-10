package co.kr.fourteen.common.util.mapper;

import java.util.HashMap;

import co.kr.fourteen.common.annotation.OracleSqlMapperScan;

@OracleSqlMapperScan
public interface CertifiMapper {

	public void deleteTempKey(String phone);

	public void insertCertificationKey(HashMap<Object, Object> param);

	public String getTempKey(String phone);

}
