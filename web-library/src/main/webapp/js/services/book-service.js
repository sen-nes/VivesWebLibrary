angular.module('webLibrary.services')

    .service('Book', ['$http', function ($http) {
        var getById = function (id) {
            return $http.get('http://localhost:8080/web-library/api/books/' + id);
        }

        return {
            getById: getById
        };
    }]);