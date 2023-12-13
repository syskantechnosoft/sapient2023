import React from 'react';
import axios from 'axios';

export default class AccountsList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            accounts: null
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8090/customer/" + this.props.customerId + "/account")
            .then(res => {
                this.setState({
                    accounts: res.data
                });
            })
            .catch(err => {
                console.log("error :" + err);
            });
    }

    tabRow() {
        const tableRows = this.state.accounts.map((acct, i) => {
            return (
                <tr key={i}>
                    <td>{acct.id}</td>
                    <td>{acct.accountNumber}</td>
                    <td>{acct.accountType}</td>
                    <td>{acct.accountBranch}</td>
                    <td>{acct.accountBalance}</td>
                </tr>
            );
        });
        return tableRows;
    }
    render() {
        return (
            <div>
                <h4>List of Accounts</h4>
                <table className="table table-bordered table-sm">
                    <thead>
                        <tr>
                            <th>Account ID </th>
                            <th>Account Number</th>
                            <th>Account Type</th>
                            <th>Account Branch </th>
                            <th>Account Balance </th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.accounts ? this.tabRow() : null}
                    </tbody>
                </table>
            </div>
        );
    }
}