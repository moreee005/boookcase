private void displayRangeManga() {
        List<Mangaka> mangaka = bookList.getMangaka();
        List<Publisher> publishers = bookList.getPublisher();
        List<Comic> comics = bookList.getComic();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Rating: ");
        String ratingInput = scanner.nextLine();

        List<Comic> booksBelowRange = new ArrayList<>(); // ArrayList untuk menyimpan buku di bawah rangePrice
        List<Publisher> rangePublisher = new ArrayList<>(); //  ArrayList untuk menyimpan production cost buku di bawah rangePrice
        List<Mangaka> mangakaBelowRange = new ArrayList<>();
        for (Publisher publisher : publishers) {
            for (Comic comic1 : comics) {
                for (Mangaka mangaka1 : mangaka) {
                    String publisher1 = publisher.getName();
                    String firstName = mangaka1.getFirstName();
                    String lastName = mangaka1.getLastName();
                    String name = firstName + lastName;
                    String author1 = comic1.getAuthor();

                    // System.out.println(author1);
                    // System.out.println(publisher1);
                    //System.out.println(name);
                    if (name.equals(comic1.getAuthor())) {
                        booksBelowRange.add(comic1); // Menambahkan buku ke dalam ArrayList
                        rangePublisher.add(publisher);
                        if (comic1.getPublisher().equalsIgnoreCase(publisher.getName())) {

                            double productionCost = publisher.getProductionCost();
                            double price = 0.0;
                            if (mangaka1.getRating().equals("New Commer")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.35;

                                } else {
                                    price = productionCost * 1.25;
                                }
                            } else if (mangaka1.getRating().equals("Good")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.45;
                                } else {
                                    price = productionCost * 1.3;
                                }
                            } else if (mangaka1.getRating().equals("Best Seller")) {
                                if (comic1.getSeries()) {
                                    price = productionCost * 1.5;
                                } else {
                                    price = productionCost * 1.4;
                                }
                            }

                            if (price > 0) {
                                if (ratingInput.equals(mangaka1.getRating())) {
                                    booksBelowRange.add(comic1);
                                    rangePublisher.add(publisher);
                                    mangakaBelowRange.add(mangaka1);
                                }
                            }
                            System.out.println("Code : " + comic1.getCode());
                            System.out.println("Title : " + comic1.getTitle());
                            System.out.println("Author : " + comic1.getAuthor());
                            System.out.println("Publisher : " + comic1.getPublisher());
                            System.out.println("Series : " + comic1.getSeries());
                            System.out.println("Price: " + price);
                            System.out.println("Rating :" + mangaka1.getRating());
                            System.out.println();

                        }

                    }

                }
            }

        }
    }
