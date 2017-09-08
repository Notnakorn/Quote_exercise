var apiLink = "http://localhost:8084/rest.demo/api/quote/random";

var quote = document.getElementById("quoteID");

var getNewQuote = function () {
    var promise = fetch(apiLink);
    promise.then(function (response) {
        return response.json();
    }).then(function (data) {
        quote.innerHTML = data.quote;
    });
};

getNewQuote();
