import { render, screen } from '@testing-library/react';
import Contact from './contact';


test('renders Contact', () => {
    render(<Contact />);
    const contactPage = screen.getByText(/Contact Page/i);
    expect(contactPage).toBeInTheDocument();
  });