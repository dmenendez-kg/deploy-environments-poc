import App from './App';
import { render, screen } from '@testing-library/react';
import HeadingComponent from './HeadingComponent';

test('Always true test', () => {
  expect(true).toBeTruthy;
});

test('Heading should be Vite + React', () => {
  render(<App />);
  const headingElement = screen.getByText('Vite + React');
  expect(headingElement).toBeInTheDocument();
});

test('Heading component', () => {
  render(<HeadingComponent />);
  const headingElement = screen.getByText('Hello');
  expect(headingElement).toBeInTheDocument();
});
