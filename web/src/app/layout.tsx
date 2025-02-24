import type { Metadata } from "next";
import Navbar from "@/components/Navbar";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";

const geistSans = Geist({
    variable: "--font-geist-sans",
    subsets: ["latin"],
});

const geistMono = Geist_Mono({
    variable: "--font-geist-mono",
    subsets: ["latin"],
});

export const metadata: Metadata = {
    title: "App Inventario Tia",
};

export default function RootLayout({
    children,
}: {
    children: React.ReactNode;
}) {
    return (
        <html lang="en">
            <body
                className={`bg-zinc-900 text-gray-200 min-h-screen ${geistSans.variable} ${geistMono.variable} antialiased`}
            >
                <Navbar />
                <main className="h-screen pt-20">{children}</main>
            </body>
        </html>
    );
}
