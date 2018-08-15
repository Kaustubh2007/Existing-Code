$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Oxygen/com.cucumber.freecrm1.framework/src/main/java/features/createcase.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM create case feature",
  "description": "",
  "id": "free-crm-create-case-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Create a new case using maps",
  "description": "",
  "id": "free-crm-create-case-feature;create-a-new-case-using-maps",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is already on Free CRM Login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User enters username \u0026 password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 6
    },
    {
      "cells": [
        "kaustubhk",
        "test@456"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User logs into the application",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "User lands on Free CRM login page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User navigates to create New Case page",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "User enters case details as title \u0026 identifier \u0026 contact",
  "rows": [
    {
      "cells": [
        "title",
        "identifier",
        "contact"
      ],
      "line": 12
    },
    {
      "cells": [
        "Case1",
        "I1",
        "123456"
      ],
      "line": 13
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User logs out of the CRM application",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User quites the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateCase.user_is_already_on_Free_CRM_Login_Page()"
});
formatter.result({
  "duration": 11796547449,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_enters_username_password(DataTable)"
});
formatter.result({
  "duration": 261978042,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_logs_into_the_application()"
});
formatter.result({
  "duration": 21605225349,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_lands_on_Free_CRM_login_page()"
});
formatter.result({
  "duration": 18306857,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_navigates_to_create_New_Case_page()"
});
formatter.result({
  "duration": 10353293659,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_enters_case_details_as_title_identifier_contact(DataTable)"
});
formatter.result({
  "duration": 11828224551,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_logs_out_of_the_CRM_application()"
});
formatter.result({
  "duration": 3105370580,
  "status": "passed"
});
formatter.match({
  "location": "CreateCase.user_quites_the_browser()"
});
formatter.result({
  "duration": 657927665,
  "status": "passed"
});
});