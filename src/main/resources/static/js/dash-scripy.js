// scripts.js

let loans = [];
let activeLoans = [];
let totalInterestEarned = 0;
let totalLoss = 0;

const loanForm = document.getElementById("loanForm");
const customerTableBody = document.getElementById("customerTable").querySelector("tbody");
const loanTableBody = document.getElementById("loanTable").querySelector("tbody");
const activeLoansTableBody = document.getElementById("activeLoansTable").querySelector("tbody");

loanForm.addEventListener("submit", (event) => {
    event.preventDefault();

    const customerName = document.getElementById("customerName").value;
    const loanAmount = parseFloat(document.getElementById("loanAmount").value);
    const interestRate = parseFloat(document.getElementById("interestRate").value);
    const loanDuration = parseInt(document.getElementById("loanDuration").value);

    const loanId = loans.length + 1;
    const interest = (loanAmount * (interestRate / 100) * loanDuration).toFixed(2);
    const loan = { loanId, customerName, loanAmount, interest, status: "Active" };

    loans.push(loan);
    activeLoans.push(loan);

    // Add to tables
    addCustomerToTable(customerName, loanAmount, interestRate, loanDuration);
    addLoanToTable(loanId, customerName, loanAmount, interest, "Active");

    // Update profit/loss
    totalInterestEarned += parseFloat(interest);
    document.getElementById("totalProfit").innerText = `₹${totalInterestEarned}`;
    
    // Update active loans
    updateActiveLoansTable();

    loanForm.reset();
});

function addCustomerToTable(name, amount, rate, duration) {
    const row = `<tr>
        <td>${name}</td>
        <td>₹${amount}</td>
        <td>${rate}%</td>
        <td>${duration} years</td>
    </tr>`;
    customerTableBody.innerHTML += row;
}

function addLoanToTable(id, name, amount, interest, status) {
    const row = `<tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>₹${amount}</td>
        <td>₹${interest}</td>
        <td>${status}</td>
    </tr>`;
    loanTableBody.innerHTML += row;
}

function updateActiveLoansTable() {
    activeLoansTableBody.innerHTML = "";
    activeLoans.forEach(loan => {
        const row = `<tr>
            <td>${loan.loanId}</td>
            <td>${loan.customerName}</td>
            <td>₹${loan.loanAmount}</td>
            <td>Due Soon</td>
            <td>${loan.status}</td>
        </tr>`;
        activeLoansTableBody.innerHTML += row;
    });
}

// Chart.js
function renderLoanGrowthChart() {
    const ctx = document.getElementById("loanGrowthChart").getContext("2d");
    const data = activeLoans.map(loan => loan.loanAmount);
    const labels = activeLoans.map(loan => `Loan ${loan.loanId}`);

    new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Loan Growth",
                data: data,
                borderColor: "blue",
                fill: false
            }]
        },
        options: {
            responsive: true,
        }
    });
}
