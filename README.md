Test Assignment

The assignment is to build UI + API applications (2 separate ones) with the following
functionalities:

    ● UI application displays a form and table of data polled from the API (list of encrypted
        values).
    ● The form must include a text input and “Encrypt” & “Decrypt” buttons:
        ○ Pressing “Encrypt” in the form, the provided text value is sent to API, encrypted
            and saved into the database and a new record appears in the UI table.
        ○ You can select a row from the table, the encrypted value is placed into the form’s
            text input, where you can press "Decrypt" to display the original value.
            /Or press “Encrypt” where the encrypted value is simply encrypted and saved
            again.
    ● The key pair for encryption and decryption must be stored in the API application (you
    decide on the best solution).
    ● API functionality must be tested with Unit tests.
    ● Additional points will be given if authentication is added and the key pair is connected
    to the user (not using one single key pair for everyone).

Tech limits:

        ● The API application should use the Spring (Boot) Framework.
        ● Java SE 8+.
        ● In-memory database for storing encrypted values.
        ● Use the JavaScript native Fetch API instead of jQuery for polling data from API
            application. Otherwise, UI frameworks/libraries such as React/Angular are most welcome
            for developing the UI (which already should satisfy the requirement in the previous
            sentence).