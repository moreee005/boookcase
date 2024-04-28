
    private void displayRangeCountryAuthor() {
        List<Book> books = bookList.getBooks();
        List<Publisher> publishers = bookList.getPublisher();
        List<Author> authors = bookList.getAuthor();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Country: ");
        String countryInput = scanner.nextLine();

        List<Book> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice
        List<Author> authorsBelowRange = new ArrayList<>();
        for (Author author : authors) {
            if (countryInput.equals(author.getCountry())) {
                authorsBelowRange.add(author);
            }
        }

//        Get comic
        for (Author author : authorsBelowRange) {
            String firstName = author.getFirstName();
            String lastName = author.getLastName();
            String name = firstName + lastName;
            for (Book book : books) {
                if (book.getAuthor().equals(name)) {
                    booksBelowRange.add(book);
                }
            }
        }

        for (Author author : authorsBelowRange) {
            for (Book book : booksBelowRange) {
                for (Publisher publisher : publishers) {
                    if (book.getPublisher().equals(publisher.getName())) {
                        rangePublisher.add(publisher);
                        double price = publisher.getProductionCost() * 1.2;
                        System.out.println("Code : " + book.getCode());
                        System.out.println("Title : " + book.getTitle());
                        System.out.println("Author : " + book.getAuthor());
                        System.out.println("Publisher : " + book.getPublisher());
                        System.out.println("Price: " + price);
                        System.out.println("Country :" + author.getCountry());
                        System.out.println();
                        break;
                    }
                }
            }
        }
    }
}
