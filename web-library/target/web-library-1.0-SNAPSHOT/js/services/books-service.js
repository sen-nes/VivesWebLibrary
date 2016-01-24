angular.module('webLibrary.services')

    .service('Books', ['$http', function ($http) {
        var getAll = function () {
            return $http.get('http://localhost:8080/web-library/api/books');
        }

        return {
            getAll: getAll
        };
    }]);