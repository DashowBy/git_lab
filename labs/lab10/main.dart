import 'dart:io';
import 'package:xml/xml.dart';

void main() {
  final books = returnListFromXML(File('library.xml'));
  if (books.isEmpty) return;

  printBooksInfo(books);
  filterBooks(books, 'Психология');
}

// Чтение файла xml
List<XmlElement> returnListFromXML(File file) {
  if (!file.existsSync()) {
    print('В файле отсутствуют данные!');
    return [];
  }

  final xmlString = file.readAsStringSync();
  final document = XmlDocument.parse(xmlString);
  final books = document.findAllElements('book').toList();

  return books;
}

// Основной вывод и расчёты
void printBooksInfo(List<XmlElement> books) {
  double priceTotal = 0;
  int count = 0;

  print('Все книги:\n');

  for (final book in books) {
    final title = book.getElement('title')?.innerText ?? '';
    final author = book.getElement('author')?.innerText ?? '';
    final year = book.getElement('year')?.innerText ?? '';
    final genre = book.getElement('genre')?.innerText ?? '';
    final priceStr = book.getElement('price')?.innerText ?? '0';
    final price = double.tryParse(priceStr) ?? 0;

    priceTotal += price;
    count++;

    print('Название: $title');
    print('Автор: $author');
    print('Год: $year');
    print('Жанр: $genre');
    print('Цена: $price\n');
  }

  final avg = (count > 0) ? (priceTotal / count) : 0;
  print('Средняя цена: ${avg.toStringAsFixed(2)}\n');
}

// Фильтрация по жанру
void filterBooks(List<XmlElement> books, String filter) {
  print('Книги в жанре "$filter":\n');

  for (final book in books) {
    final genre = book.getElement('genre')?.innerText ?? '';
    if (genre == filter) {
      final title = book.getElement('title')?.innerText ?? '';
      final author = book.getElement('author')?.innerText ?? '';
      print('$title — $author');
    }
  }
}