import { PlatformBanner } from "./components/PlatformBanner";
import { Hero } from "./components/Hero";
import { PlatformSupport } from "./components/PlatformSupport";
import { Features } from "./components/Features";
import { Footer } from "./components/Footer";

export default function App() {
  return (
    <div className="min-h-screen bg-background">
      <main>
        <div className="flex flex-col md:h-screen">
            <Hero className="flex-1 flex items-center"/>
            <PlatformBanner />
        </div>
        <Features />
        <PlatformSupport />
      </main>
      <Footer />
    </div>
  );
}