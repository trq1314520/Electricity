package com.es.library.service.impl;

import java.util.List;

import com.es.library.dao.LibraryDao;
import com.es.library.domain.Library;
import com.es.library.service.LibraryService;

public class LibraryServiceImpl implements LibraryService {
private LibraryDao libraryDao;

	public void setLibraryDao(LibraryDao libraryDao) {
	this.libraryDao = libraryDao;
}

	@Override
	public List<Library> findLibAll() {
		
		return libraryDao.findLibAll();
	}


}
