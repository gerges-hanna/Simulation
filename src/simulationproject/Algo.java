package simulationproject;

import java.util.ArrayList;
import java.util.Random;
public class Algo
{
    private ArrayList<SimulationStep> steps;
    public Algo()
    {
        
    }
    public Algo(ArrayList<SimulationStep> s)
    {
        steps = s;
    }
    public void setSimulationSteps(ArrayList<SimulationStep> s)
    {
        steps = s;
    }
    public ArrayList<SimulationStep> getSimulationSteps()
    {
        return steps;
    }
    public void generateRangeNumbers()
    {
        int lastMaxNumber = 0;
        for(int i = 0; i < steps.size(); i++)
        {
            steps.get(i).rangeMin = lastMaxNumber;
            steps.get(i).rangeMax = (int)(steps.get(i).comulative * 100.f);
            lastMaxNumber = steps.get(i).rangeMax + 1;
        }
    }
    public double startSimulate(int simulationAccuracy)
    {
        double res = 0.0;
        for(int i = 0; i < simulationAccuracy; i++)
        {
            Random rand = new Random();
            int randNumber = rand.nextInt((100 - 0) + 1) + 0;
            for(SimulationStep s : steps)
            {
                if(randNumber >= s.rangeMin && randNumber <= s.rangeMax)
                {
                    res += s.uniqueNumber;
                }
            }
        }
        return res;
    }
    public double getExpectedValue()
    {
        double result = 0.0;
        for(SimulationStep s : steps)
        {
            result += s.probability * s.uniqueNumber;
        }
        return result;
    }
}