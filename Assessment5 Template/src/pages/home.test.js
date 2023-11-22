import { render, screen } from "@testing-library/react";
import Home from "./home";
import { MemoryRouter } from "react-router-dom";

test("renders Home", () => {
  render(
    <MemoryRouter>
      <Home />
    </MemoryRouter>
  );
  const homePage = screen.getByText(/Home Page/i);
  expect(homePage).toBeInTheDocument();
});
