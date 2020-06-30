function enableEditProfile() {
    var fields = document.getElementsByClassName("blocked-input-field");
    for (var i = 0; fields.length > 0;) {
        let field = fields[i]
        field.setAttribute("class", "form-input-field ")
    }
    var buttons = document.getElementsByClassName("user-info-submit-button");
    for (var i = 0; i < buttons.length; i++) {
        let button = buttons[i]
        button.disabled = (button.disabled != true)
    }
}