import React, { Component } from "react";

class CustomerForm extends Component {
  constructor(props) {
    super(props);
    this.handleFirstNameChange = this.handleFirstNameChange.bind(this);
    this.handleLastNameChange = this.handleLastNameChange.bind(this);
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
    };
  }
  handleFirstNameChange(evt) {
    const firstName = evt.target.value;
    // console.log("firstName :",firstName);
    this.setState({
      firstName: firstName,
    });
  }

  handleLastNameChange(evt) {
    const lastName = evt.target.value;
    this.setState({
      lastName: lastName,
    });
  }

  handleEmailChange(evt) {
    const email = evt.target.value;
    this.setState({
      email: email,
    });
  }

  handleSubmit(evt) {
    evt.preventDefault();
    const newCustomer = this.state;
    this.props.addCustomer(newCustomer);
  }

  render() {
    return (
      <div>
        <h3>Customer Form</h3>
        <form className="ui form" onSubmit={this.handleSubmit}>
          <div className="form-group">
            <label className="form-label">First Name :</label>
            <input
              type="text"
              name="firstName"
              className="form-control"
              value={this.state.firstName}
              onChange={this.handleFirstNameChange}
            />
          </div>
          <div className="form-group">
            <label className="form-label">Last Name :</label>
            <input
              type="text"
              name="lastName"
              className="form-control"
              value={this.state.lastName}
              onChange={this.handleLastNameChange}
            />
          </div>
          <div className="form-group">
            <label className="form-label">Email :</label>
            <input
              type="text"
              name="email"
              className="form-control"
              value={this.state.email}
              onChange={this.handleEmailChange}
            />
          </div>
          <div className="form-group">
            <input
              type="submit"
              value="Add Customer"
              className="form-control btn btn-primary"
            />
          </div>
        </form>
      </div>
    );
  }
}

export default CustomerForm;
