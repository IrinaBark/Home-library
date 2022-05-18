package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Save implements Command {

	@Override
	public String execute(String request) {

		final int idIndex = 1;
		final int author_Index = 2;
		final int title_Index = 3;
		final int year_Index = 4;

		final String paramDelimeter = " ";

		String[] param = request.split(paramDelimeter);

		String response = null;

		Book book = new Book(Integer.parseInt(param[idIndex]), param[author_Index], param[title_Index],
				Integer.parseInt(param[year_Index]));

		ServiceProvider serviceProvider = ServiceProvider.getInstance();

		BookService bookService = serviceProvider.getBookService();
		try {
			bookService.save(book);
			response = "Book is saved successfully";
		} catch (ServiceException e) {
			response = "Error duiring book saving";
		}
		return response;
	}

}
