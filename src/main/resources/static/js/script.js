async function addCustomer (customer) {
    try {

        const response = await fetch("http://localhost:8080/EnterCustdetails",{
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(customer),

        });
        if (response.ok)
        {
            alert ("Customer Added successfully!");
            getAllCustomers(); //refresh customer list

        }
        else
        {
            console.error('Failed to add customer', response.status);
            
        }
       
    }
    catch (error)
    {
        console.error('Error adding Customer'.error);
    }

    
}
 // Fetch All Customers

async function getAllCustomers() {
    try {
        const response = await fetch("http://localhost:8080/showAllCustomerDetails");
        const customers = await response.json();
        const customerTable = document.getElementById('customerTable');
        customerTable.innerHTML = ''; // Clear table
    


        customers.forEach(customer => {
            const row = `<tr>
                <td>${customer.name}</td>
                <td>${customer.mobileNumber}</td>
                <td>${customer.address}</td>
                <td>${customer.occupation}</td>
                <td>${customer.loanAmount}</td>
            </tr>`;
            customerTable.innerHTML += row;
        });
    } catch (error) {
        console.error("Error fetching customers:", error);
    }
}

// Fetch Customer by ID
async function getCustomerbyId() {
    try{

        const response= await fetch (`http://localhost:8080/Customers/${id}`);

        if (!response.ok)
        {
            throw new Error (`Customer not found by ID ${id}` );
        }
        const customer = await response.json();
        console.log(customer); // Log customer details for testing
        // Populate table or form with customer details
    }
    catch (error)
    {
        console.error("Error fetching customer by Id:",error);


    }
}
// Add Loan
    async function addLoan(loan) {
        try {
            const response = await fetch ("http://localhost:8080/EnterLoanDetails",{
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(loan),



        });
        if(response.ok)
        {
            alert('Loan amount details successfully!');
            getAllLoanDetails();
        }
        else {
            console.log("Error to add Loan Details...", response.status);
        }
    }catch (error){
            console.error('Error adding loan:', error);

        }
        
    }

    async function getAllLoandetails() {
        try{
            const response = await fetch ("http://localhost:8080/showAllLoanDetails");
            const loan = await response.json();

            const loanTable = document.getElementById('loanTable');
            loanTable.innerHTML='';

            loans.forEach(loan =>
            { const row = `<tr>
                <td>${loan.customerName}</td>
                <td>${loan.loanType}</td>
                <td>${loan.loanAmount}</td>
                <td>${loan.rateOfInterest}</td>
                <td>${loan.startDate}</td>
                <td>${loan.endDate}</td>
            </tr>`;
            loanTable.innerHTML += row;
        });

        }
        catch (error)
        {
            console.error("Error fetching loan Details...", error);
        }
        
    }
// Fetch Loan by ID
async function getLoanById(id) {
    try {
        const response = await fetch(`http://localhost:8080/LoanDetails/${id}`);
        if (!response.ok) {
            throw new Error(`Loan not found with ID ${id}`);
        }
        const loan = await response.json();
        console.log(loan); // Log loan details for testing
        // Populate table or form with loan details
    } catch (error) {
        console.error("Error fetching loan by ID:", error);
    }
}
    
        
        

 // Event Listeners for Forms
document.getElementById('customerForm').addEventListener('submit', event => {
    event.preventDefault();
    const customer = {
        name: document.getElementById('name').value,
        mobileNumber: document.getElementById('mobileNumber').value,
        address: document.getElementById('address').value,
        occupation: document.getElementById('occupation').value,
        loanAmount: document.getElementById('loanAmount').value,
    };
    addCustomer(customer);
});
    
document.getElementById('loanForm').addEventListener('submit', event => {
    event.preventDefault();
    const loan = {
        customerName: document.getElementById('customerName').value,
        loanType: document.getElementById('loanType').value,
        loanAmount: document.getElementById('loanAmount').value,
        rateOfInterest: document.getElementById('rateOfInterest').value,
        startDate: document.getElementById('startDate').value,
        endDate: document.getElementById('endDate').value,
    };
    addLoan(loan);
});
    

    
