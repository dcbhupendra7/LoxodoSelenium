@tag
  Feature: Receive Task Process
Background: Launch the loxodo website
    @LoginReceiveTask
    Scenario Outline: Process receive task and receive confirm regular item
      Given Launch the loxodo website
      And Login with <tenant> ,  <username> and <password>
      And open  inbound request page
      And click on latest Receive Task
      When Start the task and receive confirm items
      Then Receive task should gets completed and done button close the task.
      Examples:
        | tenant    | username                | password  |
        | soundcore | bhupendra@soundcore.com | bhupendra |
