package com.es.library.action;

import com.es.library.domain.Library;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//��װLIbrary������
public class LibraryAction extends ActionSupport implements ModelDriven<Library> {
private Library library=new Library();
@Override
public Library getModel() {

	return library;
}

}
