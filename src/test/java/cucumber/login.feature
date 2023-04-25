@tag
  Feature: Login to the website
    @tag1
    Scenario Outline: Logging with correct details and adding inbound request for regular item.
      Given Login with <tenant> ,  <username> and <password>
#      When open inbound request enter <poid> , <extid>, select dates, ener <companyname>, <emailadress> for shipping and supplier
      When click latest request on  request page and release
      And  Click on no option to create receive task
      Then <releaseMessage> message gets displayed on releasing the inbound request.

      Examples:
        | tenant    | username                | password  | releaseMessage                                 |
        | soundcore | bhupendra@soundcore.com | bhupendra | Inbound Delivery Request Successfully Released |
