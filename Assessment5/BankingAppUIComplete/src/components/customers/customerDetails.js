import React from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import AccountsList from '../accounts/accountsList';


export default class CustomerDetails extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            customer: ''
        };
    }

    componentDidMount = () => {
        const custId = this.props.match.params.id;
        console.log("CustID:" + custId);
        if (custId) {
        axios.get("http://localhost:8090/customer/" + custId)
            .then(res => {
                this.setState({
                    customer: res.data
                });
            })
            .catch(err => {
                console.log("Error" + err);
            });
        }
    }

    getCustomerDetailsDiv() {
        const { customer } = this.state; //const customer = this.state.customer
        const backLineText = "< Back to Customers List";

        return (
            <div>
                <div className="row">
                    <Link color="primary" to="/customers">
                        {backLineText}
                    </Link>
                </div>
                <div className="row">
                    <div className="col-md-4">
                        <h4>Customer Details</h4>
                        <hr />
                        <p>ID: {customer.id}</p>
                        <p>FirstName: {customer.firstName}</p>
                        <p>LastName: {customer.lastName}</p>
                        <p>Email: {customer.email}</p>
                        <p>Phone: {customer.phone}</p>
                    </div>
                    <div className="col-md-8">
                        <AccountsList customerId={customer.id} />
                    </div>
                </div>
            </div>
        );


    }
    render() {
        return (<div>
            {this.state.customer ? this.getCustomerDetailsDiv() : null}
        </div>);
    }

    // const customerData = props.customer;
    // return (
    //     <div>
    //         <h3>Customer Details</h3>
    //         <hr />
    //         <p> ID :  {customerData.id}</p>
    //         <p> First Name :  {customerData.firstName}</p>
    //         <p> Last Name :  {customerData.lastName}</p>
    //         <p> EMail :  {customerData.email}</p>
    //     </div>
    // );
}
