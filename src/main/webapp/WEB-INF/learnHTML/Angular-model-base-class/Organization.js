

Organization.apiResponseTransformer = function (responseData) {
    if (angular.isArray(responseData)) {
        return responseData
            .map(Organisation.build)
            .filter(Boolean);
    }
    return Organisation.build(responseData);
};