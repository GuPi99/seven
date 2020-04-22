package com.ally.sevenprint.service;

import com.ally.sevenprint.bean.SevenPrint;

public interface SevenPrintService {

	Boolean addSevenPrint(SevenPrint sevenPrint);

	SevenPrint selectSevenPrint(Integer id);

	Boolean deletesevenPrint(Integer id);

	Boolean updateSevenPrint(SevenPrint sevenPrint);

	String selectUrl(Integer getaPid);



}
