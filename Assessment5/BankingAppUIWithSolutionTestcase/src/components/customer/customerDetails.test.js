import { render, screen } from "@testing-library/react";
import CustomerDetails from "./customerDetails";
import { MemoryRouter as Router, Routes, Route } from "react-router-dom";


test("renders Customer Details", () => {
//     jest.mock('react-router-dom', () => ({
//         ...jest.requireActual('react-router-dom'),
//         mockId: () => [new useParams({ id: 1 })],
//       }));
//   render(<MemoryRouter><CustomerDetails /></MemoryRouter>);
render(
    <Router initialEntries={["/customers/1"]}>
      <Routes>
        <Route path="/customers/:id" element={<CustomerDetails />} />
      </Routes>
    </Router>
  );
  const custDetailsElement = screen.getByText(/Customer Details!!!/i);
  expect(custDetailsElement).toBeInTheDocument();
});
