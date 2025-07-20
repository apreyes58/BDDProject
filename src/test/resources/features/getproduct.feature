Feature: Getting specific products off of website based on id

  Scenario Outline: Status code of products call

    Given User calls service <url>
    Then Service returns status code <code>

    Examples:
      | url        | code |
      | "products" | 200  |

  Scenario Outline: Getting product using product id

    Given User calls service <url>
    Then Service returns <title>, <price>, <description>, <category>, <image>, <rating>, <status>

    Examples:
      | url           | title                                                                         | price | description                                                                                                                                                                                              | category   | image                                                              | rating                  | status  |
      | "products/5"  | "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet" | "695" | "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection." | "jewelery" | "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg" | "{rate=4.6, count=400}" | "green" |
      | "products/99" | " "                                                                           | "0"   | " "                                                                                                                                                                                                      | " "        | " "                                                                | " "                     | "red"   |
      | "products/2"  | "xx"                                                                          | "xx"  | "xx"                                                                                                                                                                                                     | "xx"       | "xx"                                                               | "xx"                    | "red"   |
