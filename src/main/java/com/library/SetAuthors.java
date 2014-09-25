package com.library;

import com.library.model.Author;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by alitvin on 9/24/2014.
 */
public  class SetAuthors<T extends Author> extends HashSet<Author> {
	public String toString(){
		StringBuilder sb=new StringBuilder();
		Iterator<Author> i = this.iterator();
		while (i.hasNext()){
			Author a = i.next();
			sb.append(a.getFirstname()+"   "+a.getLastname());
			if (i.hasNext()) sb.append(" and ");
		}
		return sb.toString();
	}
}
