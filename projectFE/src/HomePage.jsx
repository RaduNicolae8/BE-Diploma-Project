import { Button, Container, FormControl, FormLabel, Heading, Input, Stack } from "@chakra-ui/react";
import { useState } from "react";
import AuthService from "./AuthService";

const HomePage = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = () => {
        AuthService.login(email, password).then(
            () => {
                window.location.href = "/dashboard";
            },
            (error) => {
                console.log(error);
            }
        );
    };

    const handleSignup = () => {
        // Handle signup logic
    };

    return (
        <Container maxW="container.md">
            <Stack spacing={6}>
                <Heading as="h1" size="xl">
                    Welcome to the Marketplace
                </Heading>
                <Stack direction="column" spacing={3}>
                    <FormControl id="email">
                        <FormLabel>Email address</FormLabel>
                        <Input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                    </FormControl>
                    <FormControl id="password">
                        <FormLabel>Password</FormLabel>
                        <Input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </FormControl>
                    <Button colorScheme="teal" onClick={handleLogin}>
                        Login
                    </Button>
                </Stack>
                <Stack direction="column" spacing={3}>
                    <FormControl id="email">
                        <FormLabel>Email address</FormLabel>
                        <Input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
                    </FormControl>
                    <FormControl id="password">
                        <FormLabel>Password</FormLabel>
                        <Input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                    </FormControl>
                    <Button colorScheme="teal" onClick={handleSignup}>
                        Signup
                    </Button>
                </Stack>
            </Stack>
        </Container>
    );
};

export default HomePage;
